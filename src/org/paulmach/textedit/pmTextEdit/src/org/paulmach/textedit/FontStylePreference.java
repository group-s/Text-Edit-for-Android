package org.paulmach.textedit;

import java.util.Arrays;
import java.util.List;

import org.paulmach.textedit.FontSizePreference.FontTypeArrayAdapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.preference.DialogPreference;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class FontStylePreference  extends DialogPreference
{

	private List<String> fonts = null;
	private int selected;
	
	public FontStylePreference(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		
		SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getContext());
		String font = sharedPref.getString("fontstyle", "normal");
	
		if (font.equals("normal"))
			selected = 0;
		else if (font.equals("bold"))
			selected = 1;
		else if (font.equals("italic"))
			selected = 2;
		else if (font.equals("bold_italic"))
			selected = 3;
		
	}
	
	@Override
	protected void onPrepareDialogBuilder(AlertDialog.Builder builder){
	    // Data has changed, notify so UI can be refreshed!
		builder.setTitle("Choose a font style");
		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				
				// save the choice in the preferences
				Editor editor = PreferenceManager.getDefaultSharedPreferences(getContext()).edit();		
				
				if (selected == 0)
					editor.putString("fontstyle", "normal");
				else if (selected == 1)
					editor.putString("fontstyle", "bold");
				else if (selected == 2)
					editor.putString("fontstyle", "italic");
				else if (selected == 3)
					editor.putString("fontstyle", "bold_italic");
				
				
				
				editor.commit();
				
				notifyChanged();
			}
		});
		builder.setNegativeButton("Cancel", null);
	
		String[] arrayOfFontStyle = {"normal","bold","italic","bold_italic"};
        fonts = Arrays.asList(arrayOfFontStyle);

		FontTypeArrayAdapter adapter = new FontTypeArrayAdapter(getContext(), android.R.layout.simple_list_item_single_choice, fonts);
		builder.setSingleChoiceItems(adapter, selected, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				// make sure we know what is selected
				selected = which;
			}
		});		
    } // onPrepareDialogBuilder()
	/********************************************************************
	 * class FontTypeArrayAdapter
	 * 		Array adapter for font type picker */
	public class FontTypeArrayAdapter extends ArrayAdapter<String>
	{
		// just a basic constructor
		public FontTypeArrayAdapter(Context context, int resource, List<String> objects) {
			super(context, resource, objects);
			
		} // end constructor one
		
		/****************************************************************
		 * getView
		 * 		the overroad getView method */
		public View getView(int position, View convertView, ViewGroup parent) 
		{
			// get the view that would normally be returned
			View v = super.getView(position, convertView, parent);
			final TextView tv = (TextView) v;
		
				
			final String option = tv.getText().toString();			
			if (option.equals("normal"))
				tv.setTextSize(16.0f);
			
			else if (option.equals("bold"))
			{
				tv.setTextSize(16.0f);
				tv.setTypeface(null, Typeface.BOLD);
		//		tv.setText
			}
			else if (option.equals("italic"))
			{
				tv.setTypeface(null, Typeface.ITALIC);
				tv.setTextSize(16.0f);
			}
			else if (option.equals("bold_italic"))
			{
				tv.setTypeface(null, Typeface.BOLD_ITALIC);
				tv.setTextSize(16.0f);
			}
			
			tv.setTextColor(Color.BLACK);
			tv.setPadding(10, 3, 3, 3);
		
			return v;	
		} // end getView()

	} // end class FontTypeArrayAdapter
	
} // end class ClearListPreference
