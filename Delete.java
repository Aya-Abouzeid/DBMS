package eg.edu.alexu.csd.oop.DBMS;

public class Delete extends Validate{
	boolean Executed;
	public boolean GetExecuted(){
		return Executed;
	}
	 public int Delete(Boolean IsDBFound , String CurrentUsedDB,String GetRestSentence ,Queries query) {
			this.Query = query;

		 Executed = false;
		 int UpdateCount = 0;
		 DBfound = IsDBFound;
		 GetRest = GetRestSentence;
		 differ=false;
		 CurrentlyUsedDB = CurrentUsedDB;
	    	
	        del = true;
	        String Rest = GetRest;
	        Rest = TrimCommand(Rest);
	        if (Rest==null||(GetRest.toLowerCase().contains("where") && GetRest.contains("*"))) {
	            System.out.println("Invalid Command.");
	        } else {
	            Rest = TrimCommand(Rest.replace("*", " "));
	            boolean s1 = check_from_state(Rest);
	            boolean s2 = true;
	            if (Rest == null) {
	                System.out.println("Invalid Command.");
	            } else {
	            	boolean withwhere=false;
	                if (Rest.toLowerCase().contains("where")) {
	                	withwhere=true;
	                    s2 = check_where_state(Rest);
	                }
	                if (s1 == false || s2 == false) {
	                    System.out.println("Invalid Command.");
	                }
	                else {
	                	if(withwhere){	   
	                		Query.deleteSubTable(CurrentUsedDB, current_table1, condition);
	                		Executed = true;
	            			System.out.println("Deleted.");

	                	}
	                	else{
	                		Query.deleteTable(CurrentUsedDB, current_table1);
	                		Executed = true;
	            			System.out.println("Table is Deleted");
	                		}
	                }
	            }
	            del = false;
	        }
	 return UpdateCount;   
	 }
	 
}
