package com.ezmart.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

//혬VO

@Data
@AllArgsConstructor
@NoArgsConstructor

public class tbl_basketall {

	private int b_seq;
	private String b_date;
	private String b_check;

	private int p_seq;
	private String p_name;
	private int p_price;
	private String p_image;
	private String p_cate;
	private int p_sort;

	private String mb_id;
<<<<<<< HEAD
	
	private int b_amount;
=======
	private String p_barcode;
>>>>>>> branch 'master' of https://github.com/2022-SMHRD-KDT-IoT-4/easycartinezmart.git

}
