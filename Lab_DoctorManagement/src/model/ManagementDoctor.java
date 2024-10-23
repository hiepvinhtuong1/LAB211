/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.HashMap;

/**
 *
 * @author Admin
 */
public class ManagementDoctor {

    private HashMap<String, Doctor> doctorHash;

    public ManagementDoctor() {
        doctorHash = new HashMap<>();
    }

    public HashMap<String, Doctor> getDoctorHash() {
        return doctorHash;
    }

    public void setDoctorHash(HashMap<String, Doctor> doctorHash) {
        this.doctorHash = doctorHash;
    }

    public Doctor getDoctorByCode(String code) throws Exception {
        if (code == null) {
            throw new Exception("code is null");
        }
        if (doctorHash == null) {
            throw new Exception("Database does not exist");
        }
        if (!doctorHash.containsKey(code)) {
            throw new Exception("Doctor code doesn’t exist");
        }
        return doctorHash.get(code);
    }

    public boolean addDoctor(Doctor doctor) throws Exception {
        if (doctor == null) {
            throw new Exception("Data does not exist");
        }
        if (doctorHash == null) {
            throw new Exception("Database does not exist");
        }
        if (doctorHash.containsKey(doctor.getCode())) {
            throw new Exception("Doctor code " + doctor.getCode() + " is duplicate");
        }
        doctorHash.put(doctor.getCode(), doctor);
        return true;
    }

    public boolean updateDoctor(Doctor doctor) throws Exception {
        if (doctor == null) {
            throw new Exception("Data doesn't exist");
        }
        if (doctorHash == null) {
            throw new Exception("Database does not exist");
        }
        if (!doctorHash.containsKey(doctor.getCode())) {
            throw new Exception("Doctor code doesn’t exist");
        }

        doctorHash.put(doctor.getCode(), doctor); // Thay thế dữ liệu cũ
        return true;
    }

    public boolean deleteDoctor(String code) throws Exception {
        if (code == null) {
            throw new Exception("Code is null");
        }
        if (doctorHash == null) {
            throw new Exception("Database does not exist");
        }
        if (!doctorHash.containsKey(code)) {
            throw new Exception("Doctor code doesn’t exist");
        }

        doctorHash.remove(code);
        return true;
    }

    public HashMap<String, Doctor> searchDoctor(String input, int mode) throws Exception {
        if (doctorHash == null) {
            throw new Exception("Database does not exist");
        }
        if (input == null || input.isEmpty()) {
            throw new Exception("Search keyword is empty");
        }

        HashMap<String, Doctor> doctors = new HashMap<>();
        for (Doctor doc : doctorHash.values()) {
            switch (mode) {
                case 1:
                    if (doc.getCode().contains(input)) {
                        doctors.put(doc.getCode(), doc);
                    }
                    break;
                case 2:
                    if (doc.getName().contains(input)) {
                        doctors.put(doc.getCode(), doc);
                    }
                    break;
                case 3:
                    if (doc.getSpecialization().contains(input)) {
                        doctors.put(doc.getCode(), doc);
                    }
                    break;
                default:
                    break;
            }
        }
        if (doctors.isEmpty()) {
            throw new Exception("No doctor found with keyword: " + input);
        }
        return doctors;
    }

    public void addFakeData() {
        doctorHash.put("DOC001", new Doctor("DOC001", "Dr. John Doe", "Cardiology", 10));
        doctorHash.put("DOC002", new Doctor("DOC002", "Dr. Jane Smith", "Neurology", 5));
        doctorHash.put("DOC003", new Doctor("DOC003", "Dr. Alice Brown", "Dermatology", 8));
        doctorHash.put("DOC004", new Doctor("DOC004", "Dr. Bob Johnson", "Orthopedics", 12));
        doctorHash.put("DOC005", new Doctor("DOC005", "Dr. Clara White", "Pediatrics", 7));
    }
}
