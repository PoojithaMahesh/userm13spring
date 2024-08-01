package com.jsp.userm12.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseStructure<T> {

	private int httpStatus;
	private String message;
	private Object data;
}
