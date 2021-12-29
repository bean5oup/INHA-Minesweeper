package com.bean3oup.setting;

import java.util.ArrayList;

public class SettingBoard {
	public String setBoard(int row, int col) {
		String table = "<table>";
		for(int i = 0; i < row; i++) {
			table += "<tr>";
			for(int j = 0; j < col; j++) {
				table += "<td></td>";
			}
			table += "</tr>";
		}
		table += "</table>";
		return table;
	}
	public ArrayList<Integer> setMine(int mine, int size) {
		ArrayList<Integer> minepos = new ArrayList<Integer>();
		for(int i = 0; i < mine; i++) {
			int rnd = (int) Math.floor(Math.random() * size);
			if(minepos.indexOf(rnd) == -1) {
				minepos.add(rnd);
			}
			else
				i--;
		}
		return minepos;
	}
}
