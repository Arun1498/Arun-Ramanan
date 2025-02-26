export default function StudentList() {
    const students = [
      { name: "Hariharan", department: "ECE" },
      { name: "Ravi", department: "ECE" },
      { name: "Arun", department: "ECE" }
    ];
  
    return (
      <div>
        <h2 >Student List</h2>
        <ul>
          {students.map((student, index) => (
            <li key={index}>
              {student.name} - {student.department}
            </li>
          ))}
        </ul>
      </div>
    );
  }