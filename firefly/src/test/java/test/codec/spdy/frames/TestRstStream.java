package test.codec.spdy.frames;

import static org.hamcrest.Matchers.is;

import org.junit.Assert;
import org.junit.Test;

import com.firefly.codec.spdy.decode.SpdyDecoder;
import com.firefly.codec.spdy.decode.SpdyDecodingEventListener;
import com.firefly.codec.spdy.decode.SpdySessionAttachment;
import com.firefly.codec.spdy.frames.DataFrame;
import com.firefly.codec.spdy.frames.control.GoAwayFrame;
import com.firefly.codec.spdy.frames.control.HeadersFrame;
import com.firefly.codec.spdy.frames.control.PingFrame;
import com.firefly.codec.spdy.frames.control.RstStreamFrame;
import com.firefly.codec.spdy.frames.control.RstStreamFrame.StreamErrorCode;
import com.firefly.codec.spdy.frames.control.SettingsFrame;
import com.firefly.codec.spdy.frames.control.SynReplyFrame;
import com.firefly.codec.spdy.frames.control.SynStreamFrame;
import com.firefly.codec.spdy.frames.control.WindowUpdateFrame;
import com.firefly.codec.spdy.stream.Connection;
import com.firefly.net.Session;

public class TestRstStream extends TestBase {

	@Test
	public void testRstStream() throws Throwable {
		MockSession session = new MockSession();
		Connection connection = new Connection(session, false);
		try(SpdySessionAttachment attachment = new SpdySessionAttachment(connection)) {
			session.attachObject(attachment);
			
			final RstStreamFrame s = newInstance();
			SpdyDecoder decoder = new SpdyDecoder(new RstStreamEvent(){

				@Override
				public void onRstStream(RstStreamFrame rstStreamFrame, Session session) {
					System.out.println("receive rst stream frame: " + rstStreamFrame);
					Assert.assertThat(rstStreamFrame, is(s));
					
				}});
			testSpdyFrame(decoder, s, session);
		}
	}
	
	@Test
	public void testStreamErrorCode() {
		Assert.assertThat(StreamErrorCode.from(1), is(StreamErrorCode.PROTOCOL_ERROR));
		Assert.assertThat(StreamErrorCode.from(9), is(StreamErrorCode.STREAM_ALREADY_CLOSED));
		Assert.assertThat(StreamErrorCode.from(11), is(StreamErrorCode.FRAME_TOO_LARGE));
	}
	
	public static RstStreamFrame newInstance() {
		RstStreamFrame rstStreamFrame = new RstStreamFrame((short)3, 22, StreamErrorCode.INTERNAL_ERROR);
		return rstStreamFrame;
	}
	
	abstract static class RstStreamEvent implements SpdyDecodingEventListener {
		@Override
		public void onSynStream(SynStreamFrame synStreamFrame, Session session) {}

		@Override
		public void onSynReply(SynReplyFrame synReplyFrame, Session session) {}

		@Override
		public void onSettings(SettingsFrame settings, Session session) {}

		@Override
		public void onPing(PingFrame pingFrame, Session session) {}

		@Override
		public void onGoAway(GoAwayFrame goAwayFrame, Session session) {}

		@Override
		public void onHeaders(HeadersFrame headersFrame, Session session) {}

		@Override
		public void onWindowUpdate(WindowUpdateFrame windowUpdateFrame,Session session) {}

		@Override
		public void onData(DataFrame dataFrame, Session session) {}
	}
}
