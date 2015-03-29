package com.firefly.codec.spdy.decode.control;

import java.nio.ByteBuffer;

import com.firefly.codec.spdy.decode.DecodeStatus;
import com.firefly.codec.spdy.decode.Parser;
import com.firefly.codec.spdy.decode.exception.DecodingStateException;
import com.firefly.net.Session;

public class CredentialBodyParser implements Parser {

	@Override
	public DecodeStatus parse(ByteBuffer buf, Session session) {
		throw new DecodingStateException("SPDY v3.1 doesn't support Credential frame!");
	}

}
