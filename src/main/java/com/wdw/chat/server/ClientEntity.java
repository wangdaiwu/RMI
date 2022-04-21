package com.wdw.chat.server;

import com.wdw.chat.client.ClientService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientEntity {
    private Integer clientPort;
    private ClientService clientService;
}
