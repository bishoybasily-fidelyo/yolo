package com.yolo.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@AllArgsConstructor
@Accessors(chain = true)
public class Oracle implements Database {

	private User user;

	@Override
	public Type type() {
		return Type.ORACLE;
	}

}
