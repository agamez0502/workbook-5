package com.pluralsight;

import java.util.ArrayList;

public class TheApp {

    public static void main(String[] args) {

        //create an ArrayList of Asset objects
        ArrayList<Asset> miAssets = new ArrayList<>();

        //load it with your Assets - include at least 2 houses
        miAssets.add(new House("My Mansion", "2019-03-20", 3812602, "6231 St Andrews Drive", 1, 4784, 17642));
        miAssets.add(new House("My Humble Abode", "2024-12-05", 375000, "3883 Turtle Creek Blvd", 2, 3204, 10723));

        //load it with your Assets - include at least 2 vehicles
        miAssets.add(new Vehicle("My Little Car", "2022-10-28", 16000, "Honda Civic", 2018, 110580));
        miAssets.add(new Vehicle("My Sports Car", "2024-03-20", 35000, "BMW X3", 2024, 30000));
        miAssets.add(new Vehicle("My Oldy but Goody", "2019-05-02", 49000, "Ford Bronco Sport", 1969, 80023));

        //some
        System.out.println("\t\t\t\t\t╔══════════════════╗");
        System.out.println("\t\t\t\t\t║ Alondra's Assets ║");
        System.out.println("\t\t\t\t\t╚══════════════════╝\n");

        //loop thru the Asset collection displaying the description of each asset,
        //the date you acquired it, how much you paid for it, and its value
        for (Asset asset : miAssets) {
            System.out.println("══════════════════════════════════════════════════════════");
            System.out.printf("\uD83D\uDCDD Description    : %-30s%n", asset.getDescription());
            System.out.printf("\uD83D\uDCC5 Date Acquired  : %-30s%n", asset.getDateAcquired());
            System.out.printf("\uD83D\uDCB8 Original Cost  : $%,.2f%n", asset.getOriginalCost());
            System.out.printf("\uD83D\uDCB0 Current Value  : $%,.2f%n", asset.getValue());

            //you will need to use instanceof when you loop thru the Assets to detect the type of asset it is
            //once you know it is a House or Vehicle - downcast it so that you can call the methods of the specific type

            //include in the display either the address of the house
            if (asset instanceof House) {
                House house = (House) asset;
                System.out.printf("\uD83C\uDFE0 Asset Type     : House%n");
                System.out.printf("\uD83D\uDCCD Address        : %-30s%n", house.getAddress());
                System.out.printf("   Condition      : %s%n", House.getConditionInfo(house.getCondition()));
                System.out.printf("\uD83D\uDCD0 Square Footage : %,d%n", house.getSquareFoot());
                System.out.printf("\uD83C\uDF33 Lot Size       : %,d%n", house.getLotSize());
            }

            //or the year and make/model of the vehicle
            else if (asset instanceof Vehicle) {
                Vehicle vehicle = (Vehicle) asset;
                System.out.printf("\uD83D\uDE97 Asset Type     : Vehicle%n");
                System.out.printf("\uD83D\uDE98 Make/Model     : %-30s%n", vehicle.getMakeModel());
                System.out.printf("\uD83D\uDCC6 Year           : %d%n", vehicle.getYear());
                System.out.printf("\uD83E\uDDED Odometer       : %,d miles%n", vehicle.getOdometer());
            }

            System.out.println("══════════════════════════════════════════════════════════");
        }
    }
}