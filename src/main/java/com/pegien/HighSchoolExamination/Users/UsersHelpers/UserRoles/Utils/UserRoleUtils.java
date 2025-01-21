package com.pegien.HighSchoolExamination.Users.UsersHelpers.UserRoles.Utils;

import com.pegien.HighSchoolExamination.Users.enums.RolesCategory;

import java.util.HashMap;
import java.util.HashSet;

public class UserRoleUtils {
        public static HashMap<RolesCategory, HashSet<String>> rolesMap = new HashMap<>();

        static {
                // For ADMIN role
                HashSet<String> adminRoles = new HashSet<>();
                adminRoles.add("users:view");            // View all users
                adminRoles.add("users:add");             // Add a new user
                adminRoles.add("users:delete");          // Delete a user
                adminRoles.add("users:update");          // Update user details
                adminRoles.add("venues:view");           // View all venues
                adminRoles.add("venues:add");            // Add a new venue
                adminRoles.add("venues:update");         // Update venue details
                adminRoles.add("venues:delete");         // Delete a venue
                adminRoles.add("marks:update");          // Update student marks
                adminRoles.add("marks:view");            // View student marks
                adminRoles.add("examinations:create");   // Create new examinations
                adminRoles.add("examinations:update");   // Update existing examinations
                adminRoles.add("examinations:view");     // View examinations
                adminRoles.add("examinations:delete");   // Delete examinations
                adminRoles.add("students:manage");       // Manage student records
                adminRoles.add("students:view");         // View student records
                adminRoles.add("students:migrate");      // Migrate students
                adminRoles.add("students:delete");       // Delete students
                adminRoles.add("staff:manage");          // Manage staff records
                adminRoles.add("meritList:update");      // Update merit lists
                adminRoles.add("meritList:view");        // View merit lists
                adminRoles.add("reportCards:generate");  // Generate report cards
                adminRoles.add("reportCards:view");      // View report cards
                adminRoles.add("sms:send");              // Send SMS notifications
                adminRoles.add("sms:view");              // View SMS logs
                adminRoles.add("timetable:generate");    // Generate school timetable
                adminRoles.add("timetable:view");        // View school timetable
                adminRoles.add("logs:view");             // View logs
                rolesMap.put(RolesCategory.ADMIN, adminRoles);

                // For PRINCIPAL role
                HashSet<String> principalRoles = new HashSet<>();
                principalRoles.add("users:view");          // View all users
                principalRoles.add("staff:evaluate");      // Evaluate staff performance
                principalRoles.add("timetable:manage");    // Manage school timetable
                principalRoles.add("examinations:view");   // View examination details
                principalRoles.add("examinations:update"); // Update examination details
                principalRoles.add("venues:view");         // View venue details
                principalRoles.add("students:view");       // View student records
                principalRoles.add("school:overview");     // Overview of school operations
                principalRoles.add("meritList:view");      // View merit lists
                principalRoles.add("reportCards:view");    // View report cards
                principalRoles.add("sms:view");            // View SMS logs
                rolesMap.put(RolesCategory.PRINCIPAL, principalRoles);

                // For DEPUTY PRINCIPAL role
                HashSet<String> deputyPrincipalRoles = new HashSet<>();
                deputyPrincipalRoles.add("users:view");          // View all users
                deputyPrincipalRoles.add("timetable:generate");  // Generate the school timetable
                deputyPrincipalRoles.add("students:view");       // View student records
                deputyPrincipalRoles.add("venues:manage");       // Manage venue details
                deputyPrincipalRoles.add("marks:view");          // View student marks
                deputyPrincipalRoles.add("examinations:update"); // Update examination details
                deputyPrincipalRoles.add("meritList:view");      // View merit lists
                deputyPrincipalRoles.add("reportCards:view");    // View report cards
                deputyPrincipalRoles.add("sms:view");            // View SMS logs
                rolesMap.put(RolesCategory.DEPUTY_PRINCIPAL, deputyPrincipalRoles);

                // For DEAN role
                HashSet<String> deanRoles = new HashSet<>();
                deanRoles.add("students:discipline");      // Manage student discipline
                deanRoles.add("students:view");           // View student records
                deanRoles.add("marks:view");              // View marks for students
                deanRoles.add("attendance:manage");       // Manage student attendance
                deanRoles.add("meritList:view");          // View merit lists
                deanRoles.add("reportCards:view");        // View report cards
                deanRoles.add("sms:view");                // View SMS logs
                rolesMap.put(RolesCategory.DEAN, deanRoles);

                // For HOD (Head of Department) role
                HashSet<String> hodRoles = new HashSet<>();
                hodRoles.add("subjects:manage");          // Manage subjects within the department
                hodRoles.add("marks:update");             // Update marks for students in the department
                hodRoles.add("marks:view");               // View marks for students in the department
                hodRoles.add("timetable:view");           // View department timetable
                hodRoles.add("teachers:evaluate");        // Evaluate teachers in the department
                hodRoles.add("meritList:view");           // View merit lists
                hodRoles.add("reportCards:view");         // View report cards
                hodRoles.add("sms:view");                 // View SMS logs
                rolesMap.put(RolesCategory.HOD, hodRoles);

                // For SENIOR_TEACHER role
                HashSet<String> seniorTeacherRoles = new HashSet<>();
                seniorTeacherRoles.add("marks:update");         // Update marks for students
                seniorTeacherRoles.add("subjects:view");        // View subjects taught
                seniorTeacherRoles.add("students:view");        // View their students
                seniorTeacherRoles.add("reportCards:view");     // View report cards
                seniorTeacherRoles.add("sms:view");             // View SMS logs
                rolesMap.put(RolesCategory.SENIOR_TEACHER, seniorTeacherRoles);

                // For TEACHER role
                HashSet<String> teacherRoles = new HashSet<>();
                teacherRoles.add("marks:update");         // Update marks for their students
                teacherRoles.add("subjects:view");        // View subjects they teach
                teacherRoles.add("students:view");        // View their students
                teacherRoles.add("attendance:view");      // View attendance records
                teacherRoles.add("reportCards:view");     // View report cards
                teacherRoles.add("sms:view");             // View SMS logs
                rolesMap.put(RolesCategory.TEACHER, teacherRoles);

                // For NON_TEACHING_STAFF role
                HashSet<String> nonTeachingStaffRoles = new HashSet<>();
                nonTeachingStaffRoles.add("students:manage");     // Manage student-related tasks
                nonTeachingStaffRoles.add("venues:manage");       // Manage venue details
                nonTeachingStaffRoles.add("attendance:manage");   // Manage attendance records
                nonTeachingStaffRoles.add("meritList:view");      // View merit lists
                nonTeachingStaffRoles.add("reportCards:view");    // View report cards
                nonTeachingStaffRoles.add("sms:view");            // View SMS logs
                rolesMap.put(RolesCategory.NON_TEACHING_STAFF, nonTeachingStaffRoles);
        }
}
