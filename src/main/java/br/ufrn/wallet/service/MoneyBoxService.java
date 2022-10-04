package br.ufrn.wallet.service;

import br.ufrn.wallet.model.MoneyBox;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MoneyBoxService {

    public List<MoneyBox> listMoneyBoxesByAccount(Long id);

    public MoneyBox createMoneyBox(MoneyBox moneyBox);

    public void deleteMoneyBox(Long id);

    public MoneyBox getMoneyBoxById(Long id);
}
