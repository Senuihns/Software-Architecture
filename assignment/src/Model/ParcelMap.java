package Model;

import java.io.*;
import java.util.ArrayList;

import Controller.Worker;

public class ParcelMap {

    private ArrayList<Parcel> parcelArrayList;

    public ParcelMap() {
    	parcelArrayList = new ArrayList<>();
    }

    public void addParcel(Parcel parcel) {
    	parcelArrayList.add(parcel);
    }
    
    public ArrayList<Parcel> getParcelArrayList() {
    	return parcelArrayList;
    }

    public void setParcelArrayList(ArrayList<Parcel> parcelArrayList) {
		this.parcelArrayList = parcelArrayList;
	}

	public void saveParcel(File file) {
        try {
        	Parcel parcel;
            String save_data = "";

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            int i = 0;
            while( i < parcelArrayList.size()) {
            	parcel = parcelArrayList.get(i);
                save_data = parcel.getParcelNo() + "," + parcel.getDays() + "," + parcel.getWeight() + "," + parcel.getLength() + "," + parcel.getWidth() + "," + parcel.getHeight();
                i++;
            }
            bufferedWriter.write(save_data);
            bufferedWriter.newLine();
            // prevents memory leak
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public void removeParcel(File file, Object[] parcelArr, String parcelNo) {
        try {
        	Parcel parcel;
            String save_data = "";

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter("ParcelsDone.csv", true));
            bufferedWriter.write("");
            for (int i = 0; i < parcelArr.length; i++) {
            	if (!parcelArr[i].toString().contains(parcelNo)) {
            		save_data = (String) parcelArr[i];
            		bufferedWriter.write(save_data);
                    bufferedWriter.newLine();
            	} else {
            		save_data = (String) parcelArr[i] + "," + new Worker().calculateFee((String) parcelArr[i]) + ",done";
            		bufferedWriter2.write(save_data);
            		bufferedWriter2.newLine();
            	}
            }
            bufferedWriter.close();
            bufferedWriter2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object[] loadParcels(File file) {
        Object[] objects;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            // each lines to array
            objects = bufferedReader.lines().toArray();
            bufferedReader.close();
            return objects;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
