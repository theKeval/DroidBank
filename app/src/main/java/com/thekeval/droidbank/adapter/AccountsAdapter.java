package com.thekeval.droidbank.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thekeval.droidbank.R;
import com.thekeval.droidbank.model.BankAccount;
import com.thekeval.droidbank.model.FixedDepositAccount;
import com.thekeval.droidbank.model.SalaryAccount;
import com.thekeval.droidbank.model.SavingAccount;

import java.util.ArrayList;

public class AccountsAdapter extends RecyclerView.Adapter<AccountsAdapter.AccountVH> {

    private Context context;
    private ArrayList<BankAccount> lstAccounts;
    private LayoutInflater inflater;

    int selected_position = 0; // You have to set this globally in the Adapter class

    public AccountsAdapter(Context ctx, ArrayList<BankAccount> lstAccs) {
        context = ctx;
        lstAccounts = lstAccs;
        inflater = LayoutInflater.from(ctx);
    }

    @NonNull
    @Override
    public AccountVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View accView = inflater.inflate(R.layout.item_account, parent, false);
        AccountVH accVH = new AccountVH(accView);

        return accVH;
    }

    @Override
    public void onBindViewHolder(@NonNull AccountVH holder, int position) {
        BankAccount acc = lstAccounts.get(position);

        holder.tvAccName.setText(acc.getClass() == SavingAccount.class ? "Saving Account" : (acc.getClass() == SalaryAccount.class ? "Salary Account" : (acc.getClass() == FixedDepositAccount.class ? "Fixed Deposit Account" : "Bank Account")));
        holder.tvAccBalance.setText("$ " + acc.getAccountBalance());

        // highlighting the background
        holder.itemView.setBackgroundColor(selected_position == position ? context.getResources().getColor(R.color.blue_extra_light) : Color.TRANSPARENT);
    }

    @Override
    public int getItemCount() {
        return lstAccounts.size();
    }

    public class AccountVH extends RecyclerView.ViewHolder {

        TextView tvAccName, tvAccBalance;

        public AccountVH(@NonNull View itemView) {
            super(itemView);

            tvAccName = itemView.findViewById(R.id.tvAccName);
            tvAccBalance = itemView.findViewById(R.id.tvAccBalance);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Below line is just like a safety check, because sometimes holder could be null,
                    // in that case, getAdapterPosition() will return RecyclerView.NO_POSITION
                    if (getAdapterPosition() == RecyclerView.NO_POSITION) return;

                    // Updating old as well as new positions
                    notifyItemChanged(selected_position);
                    selected_position = getAdapterPosition();
                    notifyItemChanged(selected_position);
                }
            });

        }

    }
}
