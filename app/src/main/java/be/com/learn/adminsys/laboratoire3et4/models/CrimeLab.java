package be.com.learn.adminsys.laboratoire3et4.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class CrimeLab {
    private static CrimeLab sCrimeLab;
    private List<Crime> mCrimes;
    public static CrimeLab get() {
        if(sCrimeLab == null) {
            sCrimeLab = new CrimeLab();
        }
        return sCrimeLab;
    }
    private CrimeLab() {
        mCrimes = new ArrayList<>();
        // initialisation avec des crimes bidons.
        for(int i = 0; i < 100; i++) {
            Crime crime = new Crime();
            crime.setTitle("Crime #" + i);
            crime.setSolved(i%2==0); // un sur deux résolu
            mCrimes.add(crime);
        }
    }
    public Crime getCrime(UUID id) {
        for (Crime crime : mCrimes) {
            if(crime.getId().equals(id))
                return crime;
        }
        return null;
    }
    public List<Crime> getCrimes() {
        return Collections.unmodifiableList(mCrimes);
    }
}