/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_server;

import helper.BubleSort;
import helper.NumberSorter;
import helper.QuickSort;

import java.util.Arrays;

/**
 *
 * @author thiennd
 */
public class Sorter {
	private static NumberSorter sortAlgorithm;

	private static Sorter instance;

	public static Sorter getInstance() {
		if (instance == null) 
			instance = new Sorter();
	
		return instance;
	}

	public Sorter() {
		setAlgorithm();
	}

	public int[] sort(int[] input) {
		return sortAlgorithm.sort(input);
	}

	private void setAlgorithm() {
		sortAlgorithm = new QuickSort();
		//sortAlgorithm = new BubleSort();
	}

}
