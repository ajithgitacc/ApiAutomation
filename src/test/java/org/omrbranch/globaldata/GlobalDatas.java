package org.omrbranch.globaldata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GlobalDatas {
	private int responsecode;
	private String stateIdText;
	private String logToken;
	private int stateIdNum;
	private int cityIdNum;
	private String addressIdText;

}
