package com.example.biasharamanager;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;

import com.example.biasharamanager.model.Priority;
import com.example.biasharamanager.model.Product;
import com.example.biasharamanager.model.StockViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.Calendar;
import java.util.Date;

public class BottomSheetFragment extends BottomSheetDialogFragment {
    private EditText enterProduct;
    private EditText enterProductQuantity;
    private EditText enterPurchasePrice;
    private EditText enterSellingPrice;
    private ImageButton todayButton;
    private ImageButton priorityButton;
    private ImageButton saveButton;
    private RadioGroup priorityRadioGroup;
    private RadioButton selectedPriorityRadioButton;
    private int selectedButtonId;
    private CalendarView calendarView;
    private Date dateAdded;
    Calendar calendar = Calendar.getInstance();


    public BottomSheetFragment() {
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstance){
        //Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.bottom_sheet,container,false);

        calendarView = view.findViewById(R.id.calendar_view);
        enterProduct = view.findViewById(R.id.enter_product);
        enterProductQuantity = view.findViewById(R.id.edit_text_stock_quantity);
        enterPurchasePrice = view.findViewById(R.id.edit_text_buying_price);
        enterSellingPrice = view.findViewById(R.id.edit_text_selling_price);
        todayButton = view.findViewById(R.id.today_calendar_button);
        priorityButton = view.findViewById(R.id.product_priority_button);
        saveButton = view.findViewById(R.id.save_product_button);
        priorityRadioGroup = view.findViewById(R.id.priority_radioGroup);

        return view;
    }
    public void onViewCreated(@NonNull View view, Bundle savedInstance) {
        super.onViewCreated(view, savedInstance);

        calendarView.setOnDateChangeListener((view1, year, month, dayOfMonth) -> {
            //Log.d("Cal", "On_day: "+dayOfMonth +"month__> "+(month+1));
            calendar.clear();
            calendar.set(year,month,dayOfMonth);
            dateAdded = calendar.getTime();
        });


        saveButton.setOnClickListener(v1 -> {
            String productName = enterProduct.getText().toString().trim();
            if(!TextUtils.isEmpty(productName) && dateAdded != null){
                Product myProduct = new Product(productName,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        dateAdded,
                        Calendar.getInstance().getTime(),
                        Priority.CONVENIENCE,
                        false);

                StockViewModel.insert(myProduct);

        }

    });
    }
}
