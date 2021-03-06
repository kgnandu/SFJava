package ttl.domain;

public class Student implements Comparable<Student>{
	
	private int id;
	private String name;
	private Status status;
	
	private Student(int id, String name, Status status) {
		this.id = id;
		this.name = name;
		this.status = status;
	}

	public Student(String name, Status status) {
		this.name = name;
		this.status = status;
	}
	
	public Student() {}
	
	public enum Status { 
		FULL_TIME(10), 
		PART_TIME(12), 
		SLEEPING(1234);
		
		private int code;
		Status(int code) {
			this.code = code;
		}
		
		public String toString() {
			return name().substring(0, 1) + name().substring(1).toLowerCase();
		}
		
		public static Status fromPrettyString(String ps) {
			return Status.valueOf(ps.toUpperCase());
		}
		
		public int getCode() {
			return code;
		}
	};
	
	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + " status " + status + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	public static class StudentBuilder
	{
		private int id;
		private String name;
		private Status status;
		
		public StudentBuilder name(String s) {
			this.name = s;
			
			return this;
		}

		public StudentBuilder status(Status s) {
			this.status = s;
			
			return this;
		}

		public StudentBuilder id(int id) {
			this.id = id;
			
			return this;
		}
		
		public Student build() {
			Student s = new Student(id, name, status);
			
			return s;
		}
	}


	@Override
	public int compareTo(Student other) {
		return id - other.id;
	}
	

}
