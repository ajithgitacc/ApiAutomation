package org.omrbranch.pojo.productsearch;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchProduct_Output_Pojo {
	private int status;
	private String message;
	private ArrayList<Productlist> data;
	private String currency;


}
