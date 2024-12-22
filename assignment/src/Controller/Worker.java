package Controller;

import Model.Parcel;

public class Worker {
	
	public int calculateFee(String parcelArr) {
		Log.write("calculate fee");
		String [] parcel = parcelArr.split(",");
		
		int noUnit = 1, daysUnit = 1, weightUnit = 1, sizeUnit = 1;
		if (Integer.parseInt(parcel[0].substring(1)) > 500) {
			noUnit = 2;
		}
		if (Integer.parseInt(parcel[1]) > 2) {
			daysUnit = (Integer.parseInt(parcel[1]) - 2) + 1;
		}
		if (Integer.parseInt(parcel[2]) > 5) {
			weightUnit = (Integer.parseInt(parcel[2]) - 5) + 1;
		}
		if (Integer.parseInt(parcel[3]) * Integer.parseInt(parcel[4]) * Integer.parseInt(parcel[5]) > 10 ) {
			sizeUnit = 2;
		}
		return noUnit+daysUnit+weightUnit+sizeUnit ;
	}

}
