package com.seintaridis.swissos;

import java.io.Serializable;
import java.util.ArrayList;

public class EmergencyNumber implements Serializable
{
    private String label;
    private String phoneNumber;
    private String url;

    public EmergencyNumber(String label, String phoneNumber, String url)
    {
        this.label = label;
        this.phoneNumber = phoneNumber;
        this.url = url;
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

    public String getUrl()
    {
        return url;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public static ArrayList<EmergencyNumber> createEmergencyNumbersList(){
        ArrayList<EmergencyNumber> emergencyNumbers = new ArrayList<EmergencyNumber>();
        emergencyNumbers.add(new EmergencyNumber("Any Emergency","112","https://www.ch.ch/en/emergency-numbers-first-aid/"));
        emergencyNumbers.add(new EmergencyNumber("Police","117","https://polizei.ch/en"));
        emergencyNumbers.add(new EmergencyNumber("Ambulance","144","https://www.ch.ch/en/emergency-numbers-first-aid/"));
        emergencyNumbers.add(new EmergencyNumber("Fire","118","https://www.ch.ch/en/fire/"));
        emergencyNumbers.add(new EmergencyNumber("Tox Info (Poisoning)","145","https://www.toxinfo.ch/"));
        emergencyNumbers.add(new EmergencyNumber("REGA (Air Rescue)","1414","https://www.rega.ch/en/"));
        emergencyNumbers.add(new EmergencyNumber("Emergency Road Service","140","https://en.wikipedia.org/wiki/Touring_Club_Suisse"));
        return emergencyNumbers;
    }
}
