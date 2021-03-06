package test.codec.spdy.frames;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.LinkedList;

import com.firefly.codec.spdy.encode.SpdyEncoder;
import com.firefly.net.Session;
import com.firefly.net.buffer.FileRegion;

public class MockSession implements Session {
	
	private Object attachment;
	private SpdyEncoder spdyEncoder = new SpdyEncoder();
	public LinkedList<ByteBuffer> outboundData = new LinkedList<>();
	
	@Override
	public void attachObject(Object attachment) {
		this.attachment = attachment;

	}

	@Override
	public Object getAttachment() {
		return attachment;
	}

	@Override
	public void fireReceiveMessage(Object message) {
		// TODO Auto-generated method stub

	}

	@Override
	public void encode(Object message) {
		try {
			spdyEncoder.encode(message, this);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	public void write(ByteBuffer byteBuffer) {
		outboundData.offer(byteBuffer);
	}

	@Override
	public void write(FileRegion fileRegion) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getSessionId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getOpenTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getLastReadTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getLastWrittenTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getLastActiveTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getReadBytes() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getWrittenBytes() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void close(boolean immediately) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getState() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isOpen() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public InetSocketAddress getLocalAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InetSocketAddress getRemoteAddress() {
		// TODO Auto-generated method stub
		return null;
	}

}
