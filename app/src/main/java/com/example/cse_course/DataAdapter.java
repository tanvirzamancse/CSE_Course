package com.example.cse_course;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import java.util.List;

public class DataAdapter extends ArrayAdapter<PdfModel> {
    private Context context;
    private List<PdfModel> pdfData;

    public DataAdapter( Context context,List<PdfModel> pdfData) {
        super(context, R.layout.simple_pdf_row, pdfData);
        this.context=context;
       this.pdfData=pdfData;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.simple_pdf_row,parent,false);

        PdfModel pdfModel=pdfData.get(position);

        TextView textView1=view.findViewById(R.id.row2_ID);
        textView1.setText(pdfModel.getFileName().toString());
        return view;
    }


}
