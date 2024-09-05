# Hospital Management System
Project Overview
The Hospital Management System is a Java-based console application that allows for managing patient records, appointment details, and operation histories. It also includes features for room allocation and viewing current operations. The system is designed to efficiently store, update, search, and delete patient data, as well as provide detailed appointment and operation-related information.

Features
Add Patient: Register new patients with details such as name, age, blood group, gender, phone numbers, and appointment dates.
Delete Patient: Remove a patient record from the system.
Search Patient: Search for a patient's details by name.
Patient Past History: View past patient history based on their records.
Patient Appointment Details: View appointment details of patients including date and doctor information.
Update Patient: Update the details of an existing patient.
Additional Features:
Type of Treatment: Select between general checkup and operation.
View Current Operations: Display available operations along with their details like doctor name, rating, dates, and costs.
Room Allocation: Allocate rooms for admitted patients based on AC or Non-AC preferences.
Generate Receipts: Automatically generate receipts for operations performed.
How to Run
Clone the repository:

bash
Copy code
git clone <repository-link>
Compile the program:
Navigate to the project directory and compile the Java classes:

bash
Copy code
javac HospitalManagement.java
Run the application:
Execute the program:

bash
Copy code
java HospitalManagement
Usage:
Follow the on-screen instructions to interact with the hospital management system.

Code Structure
Patient Class: Represents a patient with details like name, age, blood group, gender, phone numbers, and appointment date.
HospitalManagement Class: Implements the main functionality, including patient management, operation details, and room allocation.
Operation Details
This system contains a pre-loaded list of operations, including:


Here's a sample README.md file for your Java project:

Hospital Management System
Project Overview
The Hospital Management System is a Java-based console application that allows for managing patient records, appointment details, and operation histories. It also includes features for room allocation and viewing current operations. The system is designed to efficiently store, update, search, and delete patient data, as well as provide detailed appointment and operation-related information.

Features
Add Patient: Register new patients with details such as name, age, blood group, gender, phone numbers, and appointment dates.
Delete Patient: Remove a patient record from the system.
Search Patient: Search for a patient's details by name.
Patient Past History: View past patient history based on their records.
Patient Appointment Details: View appointment details of patients including date and doctor information.
Update Patient: Update the details of an existing patient.
Additional Features:
Type of Treatment: Select between general checkup and operation.
View Current Operations: Display available operations along with their details like doctor name, rating, dates, and costs.
Room Allocation: Allocate rooms for admitted patients based on AC or Non-AC preferences.
Generate Receipts: Automatically generate receipts for operations performed.
How to Run
Clone the repository:

bash
Copy code
git clone <repository-link>
Compile the program:
Navigate to the project directory and compile the Java classes:

bash
Copy code
javac HospitalManagement.java
Run the application:
Execute the program:

bash
Copy code
java HospitalManagement
Usage:
Follow the on-screen instructions to interact with the hospital management system.

Code Structure
Patient Class: Represents a patient with details like name, age, blood group, gender, phone numbers, and appointment date.
HospitalManagement Class: Implements the main functionality, including patient management, operation details, and room allocation.
Operation Details
This system contains a pre-loaded list of operations, including:

Lungs, Brain, Eyes, Bones, Ear, and Kidneys.
Each operation has a corresponding doctor, rating, operation/discharge dates, cost, and diagnostic tests required.
Future Enhancements
File Manager Integration: A feature to open diagnostic test reports using a file selector is in development.

