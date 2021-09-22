package com.example.springevent.controller.Result;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResultBase {
	private String code;
	private String message;

	static public ResultBase OK() {
		return new ResultBase("0", "ok");
	}
}
