package com.bankmega.processor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class InquiryResponseProcessor implements Processor{
	
	public final static List<Integer> INQUIRY_RESPONSE_MESSAGE_SECTION = Arrays.asList(4,5,10,15,5,10,5,6,5,5,4,2,2,1,1,2,4,7,20,1,2,10,1,1,35,35,40,40,40,40,40,40,5,2);
	
	@Override
	public void process(Exchange exchange) throws Exception {
		
		byte[] bytes = exchange.getIn().getBody(byte[].class);
		List<String> response = new ArrayList<>();
		int index = 0;
		for (int len : INQUIRY_RESPONSE_MESSAGE_SECTION) {
			byte[] section = Arrays.copyOfRange(bytes, index, index + len);
			response.add(new String(section));
			index += len;
		}
		exchange.getOut().setBody(response);
		
	}

}
