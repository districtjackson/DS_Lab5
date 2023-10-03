import java.util.Deque;

public class History
{
	class ChangeEvent{
		boolean deletion;
		int position;
		String Change;
		
		public ChangeEvent(boolean deletion, int position, String Change) {
			deletion = this.deletion;
			position = this.position;
			Change = this.Change;
		}

	}
	
	Deque<ChangeEvent> currentChanges;
	Deque<ChangeEvent> pastChanges;



    /**
       Notepad will call this function when thier text changes.

       deletion is a boolean that indicates if the action was a deletion of text or the insertion of text.
       position is the postion where the change took place
       Change is the string of characters that is the change.
     */
   public void addEvent(boolean deletion, int position, String Change)
   {
	   ChangeEvent event = new ChangeEvent(deletion, position, Change);
	   currentChanges.addFirst(event);
	   pastChanges.clear();
   }


    /**
       Notepad will call this function when it wishes to undo the last event.

       note is a variable to the Notepad that called this function
     */
   public void undoEvent(NotePad note)
   {
	   boolean data = hasUndoData();
	   if (data == true) {
		   ChangeEvent event = currentChanges.removeFirst();
		   if (event.deletion == true) {
			   note.insert(event.position, event.Change);
		   }
		   else {
			   note.remove(event.position, event.Change.length());
		   }
	   }
   }


    /**
       Notepad will call this function when it wishes to redo the last event that was undone.
       Note that new actions should clear out events that can be "redone"
       note is a variable to the Notepad that called this function
     */
   public void redoEvent(NotePad note)
   {
   		
   }

    /**
       returns true if there is undo data in the History
     */
   public boolean hasUndoData()
   {
       return currentChanges.isEmpty();
   }

    /**
       returns true if there is undo data in the History
     */
   public boolean hasReDoData()
   {
       return false;
   }
	

}
