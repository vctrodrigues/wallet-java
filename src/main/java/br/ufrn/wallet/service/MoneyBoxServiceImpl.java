package br.ufrn.wallet.service;

import br.ufrn.wallet.model.MoneyBox;
import br.ufrn.wallet.repository.MoneyBoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MoneyBoxServiceImpl implements MoneyBoxService {

    @Autowired
    MoneyBoxRepository moneyBoxRepository;

    @Override
    public MoneyBox createMoneyBox(MoneyBox moneyBox) {
        return moneyBoxRepository.save(moneyBox);
    }

    @Override
    public void deleteMoneyBox(Long id) {
        moneyBoxRepository.deleteById(id);
    }

    @Override
    public MoneyBox getMoneyBoxById(Long id) {
        return moneyBoxRepository.findById(id).map(moneyBox -> {
            return moneyBox;
        }).orElseThrow(() -> null);
    }

    @Override
    public List<MoneyBox> listMoneyBoxesByAccount(Long id) {
        return moneyBoxRepository.findByParticipants_Id(id);
    }

}
