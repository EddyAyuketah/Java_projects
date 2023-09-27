/**
 * @author eddy ayuketah
 * @Description 
 */
import java.io.Serializable;

public class Contact implements Serializable{

        private String firstName;
        private String lastName;
        private String phoneNumber;
        private String address;
        private String emailAddress;

        
        public Contact() {
                super();
                this.firstName = "";
                this.lastName = "";
                this.phoneNumber = "";
                this.address = "";
                this.emailAddress = "";
        }
        /**
         * @param firstName
         * @param lastName
         * @param contactNo
         * @param address
         * @param emailAddress
         */
        public Contact(String firstName, String lastName, String phoneNumber, String address, String emailAddress) {
                super();
                this.firstName = firstName;
                this.lastName = lastName;
                this.phoneNumber = phoneNumber;
                this.address = address;
                this.emailAddress = emailAddress;
        }
        
       
        @Override
        public String toString() {
                return firstName+" "+lastName+", "+address+", "+emailAddress+", "+phoneNumber+"\n";
        }
        
        
        public boolean equals(Object o) {
			if(!(o instanceof Contact)) {
				return false;
			}
			Contact con = (Contact) o;
			return firstName.equals(con.firstName)&&
				   lastName.equals(con.lastName)&&
				   phoneNumber.equals(con.phoneNumber)&&
				   emailAddress.equals(con.emailAddress)&&
				   address.equals(con.address);
				   
			
			
		}
        /**
         * 
         * @return firstName
         */
		public String getFirstName() {
			return firstName;
		}
		/**
		 * 
		 * @param firstName
		 */
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		/**
		 * @return
		 */
		public String getLastName() {
			return lastName;
		}
		/**
		 * 
		 * @param lastName
		 */
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		
		public String getPhoneNumber() {
			return phoneNumber;
		}
		/**
		 * 
		 * @param phoneNumber
		 */
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		/**
		 * 
		 * @return address
		 */
		public String getAddress() {
			return address;
		}
		/**
		 * 
		 * @param address
		 */
		public void setAddress(String address) {
			this.address = address;
		}
		/**
		 * 
		 * @return
		 */
		public String getEmailAddress() {
			return emailAddress;
		}
		/**
		 * 
		 * @param emailAddress
		 */
		public void setEmailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
		}
        
        
        
        
        
        
    
        
        
}