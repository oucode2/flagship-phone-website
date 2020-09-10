package org.launchcode.flagshipphonewebsite.models;

import java.util.ArrayList;

public class phoneData {


    /**
     * Returns the results of searching the Jobs data by field and search term.
     * <p>
     * For example, searching for employer "Enterprise" will include results
     * with "Enterprise Holdings, Inc".
     *
     * @param column    Job field that should be searched.
     * @param value     Value of the field to search for.
     * @param allPhones The list of jobs to search.
     * @return List of all jobs matching the criteria.
     */
    public static ArrayList<Phone> findByColumnAndValue(String column, String value, Iterable<Phone> allPhones) {

        ArrayList<Phone> results = new ArrayList<>();

        if (value.toLowerCase().equals("all")) {
            return (ArrayList<Phone>) allPhones;
        }

        if (column.equals("all")) {
            results = findByValue(value, allPhones);
            return results;
        }
        for (Phone phone : allPhones) {

            String aValue = getFieldValue(phone, column);

            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
                results.add(phone);
            }
        }

        return results;
    }
    public static String getFieldValue(Phone phone, String fieldName){
        String theValue;
        if (fieldName.equals("name")){
            theValue = phone.getName();
        } else if (fieldName.equals("model")){
            theValue = phone.getModel().toString();
        } else {
            theValue = phone.getPrice().toString();
        }

        return theValue;
    }
    public static ArrayList<Phone> findByValue(String value, Iterable<Phone> allPhones) {
        String lower_val = value.toLowerCase();

        ArrayList<Phone> results = new ArrayList<>();

        for (Phone phone : allPhones) {

            if (phone.getName().toLowerCase().contains(lower_val)) {
                results.add(phone);
            } else if (phone.getModel().toString().toLowerCase().contains(lower_val)) {
                results.add(phone);
            } else if (phone.getPrice().toString().toLowerCase().contains(lower_val)) {
                results.add(phone);
            } else if (phone.toString().toLowerCase().contains(lower_val)) {
                results.add(phone);
            }

        }

        return results;
    }


}


