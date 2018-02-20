package org.bankmega.codec;

import java.nio.charset.Charset;
import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.handler.codec.MessageToMessageDecoder;

@Sharable
public class IBM285Decoder extends MessageToMessageDecoder<ByteBuf>{
	
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf buf, List<Object> out) throws Exception {
		String output = buf.toString(Charset.forName("IBM285"));
		byte[] bytes = output.getBytes();
		out.add(bytes);
	}

}
