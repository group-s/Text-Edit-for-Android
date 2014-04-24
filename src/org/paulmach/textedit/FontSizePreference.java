package org.paulmach.textedit;

import java.util.Arrays;
import java.util.List;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.preference.DialogPreference;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/* FontTypePreference
 * 		Special file type preference so that each option is actually 
 * 		an example of the font. */
public class FontSizePreference extends DialogPreference
{
	private List<String> fonts = null;
	private int selected;
	
	// This is the constructor called by the inflater
	public FontSizePreference(Context context, AttributeSet attrs) {
		super(context, attrs);
				
		// figure out the current size. 
		SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getContext());
		String font = sharedPref.getString("fontsize", "1");
		
		if (font.equals("8"))
			selected = 0;
		else if (font.equals("9"))
			selected = 1;
		else if (font.equals("10"))
			selected = 2;
		else if (font.equals("11"))
			selected = 3;
		else if (font.equals("12"))
			selected = 4;
		else if (font.equals("14"))
			selected = 5;
		else if (font.equals("16"))
				selected = 6;
		else if (font.equals("18"))
				selected = 7;
		else if (font.equals("20"))
				selected = 8;
		else if (font.equals("22"))
				selected = 9;
		else if (font.equals("24"))
				selected =10;
		else if (font.equals("26"))
				selected = 11;
		else if (font.equals("28"))
				selected = 12;
		else if (font.equals("36"))
			selected = 13;
		else if (font.equals("48"))
			selected = 14;
		else if (font.equals("72"))
			selected = 15;
	}
	
	@Override
	protected void onPrepareDialogBuilder(AlertDialog.Builder builder){
	    // Data has changed, notify so UI can be refreshed!
		builder.setTitle("Choose a font type");
		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				
				// save the choice in the preferences
				Editor editor = PreferenceManager.getDefaultSharedPreferences(getContext()).edit();		
				
				if (selected == 0)
					editor.putString("fontsize", "8");
				else if (selected == 1)
					editor.putString("fontsize", "9");
				else if (selected == 2)
					editor.putString("fontsize", "10");
				else if (selected == 3)
					editor.putString("fontsize", "11");
				else if (selected == 4)
					editor.putString("fontsize", "12");
				else if (selected == 5)
					editor.putString("fontsize", "14");
				else if (selected == 6)
					editor.putString("fontsize", "16");
				else if (selected == 7)
					editor.putString("fontsize", "18");
				else if (selected == 8)
					editor.putString("fontsize", "20");
				else if (selected == 9)
					editor.putString("fontsize", "22");
				else if (selected == 10)
					editor.putString("fontsize", "24");
				else if (selected == 11)
					editor.putString("fontsize", "26");
				else if (selected == 12)
					editor.putString("fontsize", "28");
				else if (selected == 13)
					editor.putString("fontsize", "36");
				else if (selected == 14)
					editor.putString("fontsize", "48");
				else if (selected == 15)
					editor.putString("fontsize", "72");
				
				
				editor.commit();
				
				notifyChanged();
			}
		});
		builder.setNegativeButton("Cancel", null);
	
		// load the font names and create the adapter
		String[] arrayOfFonts = {"8","9","10","11","12","14","16","18","20","22","24","26","28","36","48","72"};
        fonts = Arrays.asList(arrayOfFonts);

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
			if (option.equals("8"))
				tv.setTextSize(16.0f);
			else if (option.equals("9"))
				tv.setTextSize(16.0f);
			else if (option.equals("10"))
				tv.setTextSize(16.0f);
			else if (option.equals("11"))
				tv.setTextSize(16.0f);
			else if (option.equals("12"))
				tv.setTextSize(16.0f);
			else if (option.equals("14"))
				tv.setTextSize(16.0f);
			else if (option.equals("16"))
					tv.setTextSize(16.0f);
			else if (option.equals("18"))
				tv.setTextSize(16.0f);
			else if (option.equals("20"))
				tv.setTextSize(16.0f);
			else if (option.equals("22"))
				tv.setTextSize(16.0f);
			else if (option.equals("24"))
				tv.setTextSize(16.0f);
			else if (option.equals("26"))
				tv.setTextSize(16.0f);
			else if (option.equals("28"))
				tv.setTextSize(16.0f);
			else if (option.equals("36"))
				tv.setTextSize(16.0f);
			else if (option.equals("48"))
				tv.setTextSize(16.0f);
			else if (option.equals("72"))
				tv.setTextSize(16.0f);
			
			
			// general options
			tv.setTextColor(Color.BLACK);
			tv.setPadding(10, 3, 3, 3);
		
			return v;	
		} // end getView()

	} // end class FontTypeArrayAdapter
	
} // end class ClearListPreference
