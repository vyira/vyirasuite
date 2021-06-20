import React, { useState } from "react";
import {
  IPersonaSharedProps,
  Persona,
  PersonaPresence,
  PersonaSize,
  PrimaryButton,
  Stack,
} from "@fluentui/react";
import { useAppSelector } from "redux/hooks";

const Admin: React.FC = () => {
  const [presence, setPresence] = useState<PersonaPresence>(
    PersonaPresence.online
  );

  const { username, fullName } = useAppSelector((state) => state.session);

  const initials = (fullName: string | undefined) => {
    if (fullName) {
      return fullName
        .split(" ")
        .map((str) => str.substr(0).toUpperCase())
        .join();
    }
  };

  const examplePersona: IPersonaSharedProps = {
    imageUrl: "https://bit.ly/3oMTw8M",
    imageInitials: initials(fullName) || "",
    text: fullName,
    secondaryText: "Software Engineer",
    tertiaryText: "In a meeting",
    optionalText: "Available at 4:00pm",
  };

  const changePresense = () => {
    if (presence === PersonaPresence.online) {
      setPresence(PersonaPresence.away);
    } else {
      setPresence(PersonaPresence.online);
    }
  };

  return (
    <Stack tokens={{ childrenGap: 5 }}>
      <Persona
        {...examplePersona}
        presence={presence}
        size={PersonaSize.size100}
        imageAlt={username}
      />
      <PrimaryButton text={"change"} onClick={changePresense} />
    </Stack>
  );
};

export default Admin;
