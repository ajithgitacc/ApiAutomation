package org.omrbranch.pojo.changeprofilepic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeProfilePicture_Output_Pojo {
	private int status;
	private String message;
	private Picturedetails data;
	private int cart_count;

}
