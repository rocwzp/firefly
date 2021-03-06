package com.firefly.codec.spdy.frames.control;

import java.nio.ByteBuffer;

import com.firefly.codec.spdy.frames.ControlFrame;
import com.firefly.codec.spdy.frames.ControlFrameType;

public class GoAwayFrame extends ControlFrame {
	private final int lastStreamId;
	private final SessionStatus statusCode;

	public GoAwayFrame(short version, int lastStreamId, SessionStatus statusCode) {
		super(version, ControlFrameType.GO_AWAY, (byte) 0);
		this.lastStreamId = lastStreamId;
		this.statusCode = statusCode;
	}

	public int getLastStreamId() {
		return lastStreamId;
	}

	public SessionStatus getStatusCode() {
		return statusCode;
	}

	@Override
	public String toString() {
		return "GoAwayFrame [lastStreamId=" + lastStreamId + ", statusCode="
				+ statusCode + ", toString()=" + super.toString() + "]";
	}

	@Override
	public ByteBuffer toByteBuffer() {
		int frameBodyLength = 8;
        int totalLength = ControlFrame.HEADER_LENGTH + frameBodyLength;
        
        ByteBuffer buffer = ByteBuffer.allocate(totalLength);
        generateControlFrameHeader(frameBodyLength, buffer);
        buffer.putInt(lastStreamId & 0x7F_FF_FF_FF);
        buffer.putInt(statusCode.getCode());
        buffer.flip();
        return buffer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + lastStreamId;
		result = prime * result
				+ ((statusCode == null) ? 0 : statusCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		GoAwayFrame other = (GoAwayFrame) obj;
		if (lastStreamId != other.lastStreamId)
			return false;
		if (statusCode != other.statusCode)
			return false;
		return true;
	}

}
