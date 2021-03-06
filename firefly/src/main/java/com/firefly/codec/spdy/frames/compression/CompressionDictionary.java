package com.firefly.codec.spdy.frames.compression;

import java.io.UnsupportedEncodingException;

import com.firefly.utils.log.Log;
import com.firefly.utils.log.LogFactory;

abstract public class CompressionDictionary {
	
	protected static Log log = LogFactory.getInstance().getLog("firefly-system");
	
    public static final byte[] DICTIONARY_V3 = getSpdyDictionaryV3(); 
    
    private static byte[] getSpdyDictionaryV3() {
    	try {
			return
				("" +
			    "\u0000\u0000\u0000\u0007options\u0000\u0000\u0000\u0004head\u0000\u0000\u0000\u0004post" +
			    "\u0000\u0000\u0000\u0003put\u0000\u0000\u0000\u0006delete\u0000\u0000\u0000\u0005trace" +
			    "\u0000\u0000\u0000\u0006accept\u0000\u0000\u0000\u000Eaccept-charset" +
			    "\u0000\u0000\u0000\u000Faccept-encoding\u0000\u0000\u0000\u000Faccept-language" +
			    "\u0000\u0000\u0000\raccept-ranges\u0000\u0000\u0000\u0003age\u0000\u0000\u0000\u0005allow" +
			    "\u0000\u0000\u0000\rauthorization\u0000\u0000\u0000\rcache-control" +
			    "\u0000\u0000\u0000\nconnection\u0000\u0000\u0000\fcontent-base\u0000\u0000\u0000\u0010content-encoding" +
			    "\u0000\u0000\u0000\u0010content-language\u0000\u0000\u0000\u000Econtent-length" +
			    "\u0000\u0000\u0000\u0010content-location\u0000\u0000\u0000\u000Bcontent-md5" +
			    "\u0000\u0000\u0000\rcontent-range\u0000\u0000\u0000\fcontent-type\u0000\u0000\u0000\u0004date" +
			    "\u0000\u0000\u0000\u0004etag\u0000\u0000\u0000\u0006expect\u0000\u0000\u0000\u0007expires" +
			    "\u0000\u0000\u0000\u0004from\u0000\u0000\u0000\u0004host\u0000\u0000\u0000\bif-match" +
			    "\u0000\u0000\u0000\u0011if-modified-since\u0000\u0000\u0000\rif-none-match\u0000\u0000\u0000\bif-range" +
			    "\u0000\u0000\u0000\u0013if-unmodified-since\u0000\u0000\u0000\rlast-modified" +
			    "\u0000\u0000\u0000\blocation\u0000\u0000\u0000\fmax-forwards\u0000\u0000\u0000\u0006pragma" +
			    "\u0000\u0000\u0000\u0012proxy-authenticate\u0000\u0000\u0000\u0013proxy-authorization" +
			    "\u0000\u0000\u0000\u0005range\u0000\u0000\u0000\u0007referer\u0000\u0000\u0000\u000Bretry-after" +
			    "\u0000\u0000\u0000\u0006server\u0000\u0000\u0000\u0002te\u0000\u0000\u0000\u0007trailer" +
			    "\u0000\u0000\u0000\u0011transfer-encoding\u0000\u0000\u0000\u0007upgrade\u0000\u0000\u0000\nuser-agent" +
			    "\u0000\u0000\u0000\u0004vary\u0000\u0000\u0000\u0003via\u0000\u0000\u0000\u0007warning" +
			    "\u0000\u0000\u0000\u0010www-authenticate\u0000\u0000\u0000\u0006method\u0000\u0000\u0000\u0003get" +
			    "\u0000\u0000\u0000\u0006status\u0000\u0000\u0000\u0006200 OK\u0000\u0000\u0000\u0007version" +
			    "\u0000\u0000\u0000\bHTTP/1.1\u0000\u0000\u0000\u0003url\u0000\u0000\u0000\u0006public" +
			    "\u0000\u0000\u0000\nset-cookie\u0000\u0000\u0000\nkeep-alive\u0000\u0000\u0000\u0006origin" +
			    "100101201202205206300302303304305306307402405406407408409410411412413414415416417502504505" +
			    "203 Non-Authoritative Information204 No Content301 Moved Permanently400 Bad Request401 Unauthorized" +
			    "403 Forbidden404 Not Found500 Internal Server Error501 Not Implemented503 Service Unavailable" +
			    "Jan Feb Mar Apr May Jun Jul Aug Sept Oct Nov Dec 00:00:00 Mon, Tue, Wed, Thu, Fri, Sat, Sun, GMT" +
			    "chunked,text/html,image/png,image/jpg,image/gif,application/xml,application/xhtml+xml,text/plain," +
			    "text/javascript,publicprivatemax-age=gzip,deflate,sdchcharset=utf-8charset=iso-8859-1,utf-,*,enq=0.")
			    .getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			log.error("get spdy dictionary error", e);
			return null;
		}
    }
}
