package com.seintaridis.swissos;

import java.util.ArrayList;

public class EmergencyNumber
{
    private String label;
    private String phoneNumber;

    public EmergencyNumber(String label, String phoneNumber)
    {
        this.label = label;
        this.phoneNumber = phoneNumber;
    }

    public String getLabel()
    {
        return label;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public static ArrayList<EmergencyNumber> createEmergencyNumbersList(){
        ArrayList<EmergencyNumber> emergencyNumbers = new ArrayList<EmergencyNumber>();
        emergencyNumbers.add(new EmergencyNumber("Any Emergency","112"));
        emergencyNumbers.add(new EmergencyNumber("Police","117"));
        emergencyNumbers.add(new EmergencyNumber("Ambulance","144"));
        emergencyNumbers.add(new EmergencyNumber("Fire","118"));
        emergencyNumbers.add(new EmergencyNumber("Tox Info (Poisoning)","145"));
        emergencyNumbers.add(new EmergencyNumber("REGA (Air Rescue)","1414"));
        emergencyNumbers.add(new EmergencyNumber("Emergency Road Service","140"));
        return emergencyNumbers;
    }
}
