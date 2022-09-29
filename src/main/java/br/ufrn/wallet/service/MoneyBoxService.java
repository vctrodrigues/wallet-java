package br.ufrn.wallet.service;

import org.springframework.stereotype.Service;

@Service
public interface MoneyBoxService {
    
    public MoneyBox createMoneyBox(MoneyBox moneyBox);
    public void deleteMoneyBox(MoneyBox moneyBox);
    public MoneyBox getMoneyBoxById(Integer id);
    public List<MoneyBox> getListMoneyBox();


}
