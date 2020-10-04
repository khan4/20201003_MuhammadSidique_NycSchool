package com.example.a20201003_muhammadsidique_nycschools.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a20201003_muhammadsidique_nycschools.R;
import com.example.a20201003_muhammadsidique_nycschools.database.School;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Filterable {

    private List<School> items;
    private List<School> searchItemList;
    private onClickListener callBack;



    public RecyclerViewAdapter(){
        items = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SchoolViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_holder,parent,false),callBack);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof SchoolViewHolder){
            School school = items.get(position);
            ((SchoolViewHolder) holder).populate(school);
        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void submitList(List<School> schoolList, onClickListener callBack){
        List<School> oldList = items;

        SchoolListDiffCallBack schoolListDiffCallBack = new SchoolListDiffCallBack(oldList,schoolList);
        DiffUtil.DiffResult diffResult =  DiffUtil.calculateDiff(schoolListDiffCallBack);
        this.items = schoolList;

        this.callBack = callBack;

        searchItemList = new ArrayList<>(schoolList);
        diffResult.dispatchUpdatesTo(this);
    }



    class SchoolListDiffCallBack extends DiffUtil.Callback {

        private List<School> oldSchoolList;
        private List<School> newSchoolList;

        public SchoolListDiffCallBack(List<School> oldSchoolList, List<School> newSchoolList){
            this.oldSchoolList = oldSchoolList;
            this.newSchoolList = newSchoolList;
        }

        @Override
        public int getOldListSize() {
            return oldSchoolList.size();
        }

        @Override
        public int getNewListSize() {
            return newSchoolList.size();
        }

        @Override
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            return (oldSchoolList.get(oldItemPosition).getPrimaryKey() == newSchoolList.get(newItemPosition).getPrimaryKey());
        }

        @Override
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            return (oldSchoolList.get(oldItemPosition).equals(newSchoolList.get(newItemPosition)));
        }

    }


    public  class SchoolViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView tvSchoolName;
        private TextView tvCityName;
        private TextView tvZipCode;
        private onClickListener callBack;


        public SchoolViewHolder(@NonNull View itemView, onClickListener callBack) {
            super(itemView);
            tvSchoolName = itemView.findViewById(R.id.tvSchoolName);
            tvCityName = itemView.findViewById(R.id.tvCityName);
            tvZipCode = itemView.findViewById(R.id.tvZipCode);
            this.callBack = callBack;
            itemView.setOnClickListener(this);
        }

        public void populate(School school){
            tvSchoolName.setText(school.getSchoolName());
            tvCityName.setText(school.getCityName());
            tvZipCode.setText(school.getZipCode());
        }

        @Override
        public void onClick(View v) {
            callBack.clickListener(getAdapterPosition());
        }

    }
    public interface onClickListener {
        void clickListener(int position);
    }


    @Override
    public Filter getFilter() {
        return filter;
    }

    private Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            List<School> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() ==0){
                filteredList.addAll(searchItemList);
            }else{

                String filter = constraint.toString().toLowerCase().trim();

                for (School school : searchItemList){

                    if (school.getSchoolName().toLowerCase().contains(filter)){
                        filteredList.add(school);
                    }

                }

            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            items.clear();
            items.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };


}
