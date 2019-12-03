package kim.com.test.lottopicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class NewGameDialogFragment extends DialogFragment {
    static final String TAG="NewGameDialogFragment";
    EditText inputGameNumberText;
    /* The activity that creates an instance of this dialog fragment must
     * implement this interface in order to receive event callbacks.
     * Each method passes the DialogFragment in case the host needs to query it. */
    public interface NewGameDialogListener{
        public void onDialogPositiveClick(NewGameDialogFragment dialog);
        public void onDialogNegativeClick(NewGameDialogFragment dialog);
    }
    //Use this instance of the interface to deliver action events
    NewGameDialogListener listener;
    // Override the Fragment.onAttach() method to instantiate the NewGameDialogListener
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // Verify that the host activity implements the callback interface
        try{
            // Instantiate the NewGameDialogListener so we can send events to the host
            listener = (NewGameDialogListener) context;
        }catch (ClassCastException e){
            //the activity doesn't implement the interface, throw exception
            throw new ClassCastException(getActivity().toString()+"must implement NewGameDialogListener");
        }
    }

    //Override the Fragment.onAttach() method to instantiate the NewGameDialogListener
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //Get the layout inflater
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        //Inflate and set the layout for the dialog
        //Pass null as the parent view because its going in the dialog layout
        View view = inflater.inflate(R.layout.popup_input_new_game, null);
        inputGameNumberText = view.findViewById(R.id.input_game_number);
        builder.setView(view)
        // Add action buttons
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Send the positive button event back to the host activity
                        listener.onDialogPositiveClick(NewGameDialogFragment.this);
                        Log.d(TAG,inputGameNumberText.getText().toString());
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        NewGameDialogFragment.this.getDialog().cancel();
                        // Send the negative button event back to the host activity
                        listener.onDialogNegativeClick(NewGameDialogFragment.this);
                    }
                });
        return builder.create();
    }
}
