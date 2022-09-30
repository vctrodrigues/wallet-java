package br.ufrn.wallet.service;

import br.ufrn.wallet.model.Account;
import br.ufrn.wallet.model.MoneyBox;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface MoneyBoxService {
    
    public MoneyBox createMoneyBox(MoneyBox moneyBox);
    public void deleteMoneyBox(MoneyBox moneyBox);
    public MoneyBox getMoneyBoxById(Long id);
    public Set<MoneyBox> getListMoneyBox();


}
