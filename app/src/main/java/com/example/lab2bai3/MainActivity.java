package com.example.lab2bai3;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTextMaNV, editTextTenNV;
    private RadioGroup radioGroupLoaiNV;
    private RadioButton radioButtonFullTime, radioButtonPartTime;
    private Button buttonAddNV;
    private ListView listViewNV;
    private ArrayList<Employee> employeeList;
    private ArrayAdapter<Employee> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Ánh xạ các thành phần giao diện
        editTextMaNV = findViewById(R.id.editTextMaNV);
        editTextTenNV = findViewById(R.id.editTextTenNV);
        radioGroupLoaiNV = findViewById(R.id.radioGroupLoaiNV);
        radioButtonFullTime = findViewById(R.id.radioButtonFullTime);
        radioButtonPartTime = findViewById(R.id.radioButtonPartTime);
        buttonAddNV = findViewById(R.id.buttonAddNV);
        listViewNV = findViewById(R.id.listViewNV);

        // Khởi tạo danh sách và adapter
        employeeList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, employeeList);
        listViewNV.setAdapter(adapter);

        // Xử lý sự kiện khi nhấn nút Nhập NV
        buttonAddNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maNV = editTextMaNV.getText().toString();
                String tenNV = editTextTenNV.getText().toString();

                if (radioButtonFullTime.isChecked()) {
                    Employee employee = new EmployeeFullTime(maNV, tenNV, 500.0);
                    employeeList.add(employee);
                } else if (radioButtonPartTime.isChecked()) {
                    Employee employee = new EmployeePartTime(maNV, tenNV, 150.0);
                    employeeList.add(employee);
                }

                // Cập nhật ListView
                adapter.notifyDataSetChanged();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}