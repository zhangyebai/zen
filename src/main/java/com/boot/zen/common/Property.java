package com.boot.zen.common;

public class Property {
	private Property(){}

	public static final class Code{
		private Code(){}

		public static final int OK = 200;
		public static final int ERROR = 500;

	}

	public static final class Message{
		private Message(){}

		public static final String OK = "ok";
		public static final String ERROR = "error";

		public static final String ILLEGAL_ARUGMENT = "parameter is illegal for this request.";
		public static final String RUNTIME_EXCEPTION = "unknown runtime exception happens in this request.";
	}
}
