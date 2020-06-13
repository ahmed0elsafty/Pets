package com.elsafty.pets;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.elsafty.pets.data.PetContract.PetsEntry;

public class PetCursorAdapter extends CursorAdapter {
    public PetCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView nameTextView = (TextView) view.findViewById(R.id.name);
        TextView breedTextView = (TextView) view.findViewById(R.id.breed);
        TextView weightTextView = (TextView) view.findViewById(R.id.weight);
        TextView genderTextView = (TextView) view.findViewById(R.id.gender);

//        int idColumnIndex = cursor.getColumnIndex(PetsEntry._ID);
        int nameColumnIndex = cursor.getColumnIndex(PetsEntry.COLUMN_NAME);
        int breedColumnIndex = cursor.getColumnIndex(PetsEntry.COLUMN_BREED);
//        int genderColumnIndex = cursor.getColumnIndex(PetsEntry.COLUMN_GENDER);
//        int weightColumnIndex = cursor.getColumnIndex(PetsEntry.COLUMN_WEIGHT);

        String name = cursor.getString(nameColumnIndex);
        String breed = cursor.getString(breedColumnIndex);
//        int gender = cursor.getInt(genderColumnIndex);
//        String weight = cursor.getString(weightColumnIndex);
        nameTextView.setText(name);
        if (TextUtils.isEmpty(breed)) {
            breed= context.getString(R.string.unknown_breed);
        }
        breedTextView.setText(breed);
//        weightTextView.setText(weight);
//        genderTextView.setText(Integer.toString(gender));
    }
}
