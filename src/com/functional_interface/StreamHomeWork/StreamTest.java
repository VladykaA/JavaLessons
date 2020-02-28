package com.functional_interface.StreamHomeWork;

public class StreamTest {

    public static void main(String[] args) {

        ManService manService = new ManService();

        //manService.selectAllMen();

        //manService.selectAllAddresses();

        //manService.selectAllMenFirstLastChKidWhereAgeOver(30);

        //manService.updateManFirstLastNamesKindsWhereCountryIs("Germany", "changedFirstName", "ChangedLastName", 13);

        //manService.selectManFirstNLastNStreetWhereCountryAndStreetOrAge("USA", "5-th ave", 40);

        manService.selectAllMenGroupByKindsAndAge();


    }
}
