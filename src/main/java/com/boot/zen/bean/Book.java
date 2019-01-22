package com.boot.zen.bean;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class Book implements Serializable {

	@JSONField(serialize = false)
	private static final long serialVersionUID = 1L;

	@JSONField(ordinal = 0)
	private String bookId;

	@JSONField(ordinal = 1)
	private String author;

	@JSONField(ordinal = 2)
	private String name;

	@JSONField(ordinal = 3)
	private String description;

	@JSONField(ordinal = 4)
	private int price;
}
