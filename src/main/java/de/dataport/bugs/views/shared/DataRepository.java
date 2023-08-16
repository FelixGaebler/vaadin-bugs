package de.dataport.bugs.views.shared;

import java.util.ArrayList;
import java.util.List;

public class DataRepository {

	public static List<Data> mockData0() {
		List<Data> list = new ArrayList<>();

		Data data0 = new Data();
		data0.setValue("Data-0");
		list.add(data0);

		Data data1 = new Data();
		data1.setValue("Data-1");
		list.add(data1);

		Data data2 = new Data();
		data2.setValue("Data-2");
		list.add(data2);

		Data data3 = new Data();
		data3.setValue("Data-3");
		list.add(data3);

		return list;
	}

}
