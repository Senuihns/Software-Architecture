package Model;

import java.io.*;
import java.util.ArrayList;

import Controller.Worker;

public class QueofCustomers {

    private ArrayList<Cust> custArrayList;

    public QueofCustomers() {
    	custArrayList = new ArrayList<>();
    }

    public void addCust(Cust cust) {
    	custArrayList.add(cust);
    }

    public void saveCust(File file) {
        try {
            // user model
        	Cust cust;
            String save_data = "";

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            int i = 0;
            while( i < custArrayList.size()) {
            	cust = custArrayList.get(i);
                save_data = cust.getName() + "," + cust.getParcelNo();
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
    
    public void deleteCust(File file, Object[] custArr, String name) {
        try {
        	Cust cust;
            String save_data = "";

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write("");
            for (int i = 0; i < custArr.length; i++) {
            	if (!custArr[i].toString().contains(name)) {
            		save_data = (String) custArr[i];
            		bufferedWriter.write(save_data);
                    bufferedWriter.newLine();
            	}
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object[] loadCusts(File file) {
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
