package com.example.DoctorDistrtrict;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DoctorService {
    private List<Doctor> doctors = new ArrayList<>();

    public List<Doctor> getDoctors() {
        return doctors;

    }

    public DoctorService() {

        System.out.println("Создаем DoctorService");
        doctors.add(new Doctor(1, "Врач педиатр-участковый", "Иванова Ольга Ивановна", "участок 1"));
        doctors.add(new Doctor(2, "Врач педиатр-участковый", "Петров Иван Андреевич", "участок 2"));
        doctors.add(new Doctor(3, "Врач педиатр-участковый", "Васина Елена Николаевна", "участок 3"));
    }

    public Doctor getDoctorID(int id) {
        for (Doctor doctor : doctors) {
            if (doctor.getId() == id) {
                return doctor;

            }
        }
        return null;
    }
    public void removeID (int id) {
        Doctor d = getDoctorID(id);
        if(d != null)
            doctors.remove(d);
    }
}
