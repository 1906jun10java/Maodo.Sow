package com.revature.beans;

public class Reimbursement {

		int r_id;
	    Double r_amount;
	    String r_type;
	    String r_receipt;
	    String r_status;
	    java.sql.Date r_date;
	    int emp_id;
	    
		public Reimbursement(int r_id, Double r_amount, String r_type, String r_receipt, String r_status, java.sql.Date r_date,
				int emp_id) {
			super();
			this.r_id = r_id;
			this.r_amount = r_amount;
			this.r_type = r_type;
			this.r_receipt = r_receipt;
			this.r_status = r_status;
			this.r_date = r_date;
			this.emp_id = emp_id;
		}
		
		public Reimbursement(Double r_amount, String r_type, String r_receipt, String r_status, java.sql.Date r_date,
				int emp_id) {
			super();
			this.r_amount = r_amount;
			this.r_type = r_type;
			this.r_receipt = r_receipt;
			this.r_status = r_status;
			this.r_date = r_date;
			this.emp_id = emp_id;
		}

		public Reimbursement() {
			
		}


		public Reimbursement(String reimbtype, double reimbamount, String reimbdate, String reimbstatus, String empid) {
			// TODO Auto-generated constructor stub
		}

		public Reimbursement(double reimbamount, String reimbtype, String receipt, String reimbstatus, String reimbdate,
				String empid) {
			// TODO Auto-generated constructor stub
		}

		public int getR_id() {
			return r_id;
		}
		public void setR_id(int r_id) {
			this.r_id = r_id;
		}

		public Double getR_amount() {
			return r_amount;
		}
		public void setR_amount(Double r_amount) {
			this.r_amount = r_amount;
		}

		public String getR_type() {
			return r_type;
		}
		public void setR_type(String r_type) {
			this.r_type = r_type;
		}

		public String getR_receipt() {
			return r_receipt;
		}
		public void setR_receipt(String r_receipt) {
			this.r_receipt = r_receipt;
		}

		public String getR_status() {
			return r_status;
		}
		public void setR_status(String r_status) {
			this.r_status = r_status;
		}

		public java.sql.Date getR_date() {
			return r_date;
		}
		public void setR_date(java.sql.Date r_date) {
			this.r_date = r_date;
		}

		public int getEmp_id() {
			return emp_id;
		}
		public void setEmp_id(int emp_id) {
			this.emp_id = emp_id;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + emp_id;
			result = prime * result + ((r_amount == null) ? 0 : r_amount.hashCode());
			result = prime * result + ((r_date == null) ? 0 : r_date.hashCode());
			result = prime * result + r_id;
			result = prime * result + ((r_receipt == null) ? 0 : r_receipt.hashCode());
			result = prime * result + ((r_status == null) ? 0 : r_status.hashCode());
			result = prime * result + ((r_type == null) ? 0 : r_type.hashCode());
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
			Reimbursement other = (Reimbursement) obj;
			if (emp_id != other.emp_id)
				return false;
			if (r_amount == null) {
				if (other.r_amount != null)
					return false;
			} else if (!r_amount.equals(other.r_amount))
				return false;
			if (r_date == null) {
				if (other.r_date != null)
					return false;
			} else if (!r_date.equals(other.r_date))
				return false;
			if (r_id != other.r_id)
				return false;
			if (r_receipt == null) {
				if (other.r_receipt != null)
					return false;
			} else if (!r_receipt.equals(other.r_receipt))
				return false;
			if (r_status == null) {
				if (other.r_status != null)
					return false;
			} else if (!r_status.equals(other.r_status))
				return false;
			if (r_type == null) {
				if (other.r_type != null)
					return false;
			} else if (!r_type.equals(other.r_type))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Reimbursment [r_id=" + r_id + ", r_amount=" + r_amount + ", r_type=" + r_type + ", r_receipt="
					+ r_receipt + ", r_status=" + r_status + ", r_date=" + r_date + ", emp_id=" + emp_id + "]";
		}

}
    
