# PickUp Extender

A Fabric mod for Minecraft that extends the pickup range for items in the world with configurable distance.

## Features

- **Extended Pickup Range**: Pick up items from a greater distance than vanilla Minecraft
- **Configurable Distance**: Adjust the pickup range from 1 to 20 blocks
- **Toggle On/Off**: Enable or disable the extended pickup range
- **Simple Configuration**: Easy configuration through JSON file

## Configuration

The mod is configured by editing the JSON configuration file directly.

### Configuration File Location

The configuration file is located at:
- Windows: `%APPDATA%/.minecraft/config/pickupextender.json`
- macOS: `~/Library/Application Support/minecraft/config/pickupextender.json`
- Linux: `~/.minecraft/config/pickupextender.json`

### Settings

- **pickupRange**: The maximum distance (in blocks) from which you can pick up items (1-20 blocks, default: 4)
- **enabled**: Toggle the extended pickup range on/off (default: true)

### Example Configuration

```json
{
  "pickupRange": 6,
  "enabled": true
}
```

## Dependencies

- **Fabric Loader** (>=0.16.14)
- **Fabric API** (>=0.127.0)
- **Minecraft** (1.21.5)
- **Java** (>=21)

## Installation

1. Install Fabric Loader for Minecraft 1.21.5
2. Download and install Fabric API
3. Download this mod and place it in your `mods` folder
4. Edit the configuration file to adjust settings

## Building from Source

1. Clone this repository
2. Run `./gradlew build`
3. Find the built JAR in `build/libs/`

## License

This project is licensed under the CC0-1.0 License - see the [LICENSE](LICENSE) file for details.

## Author

Patrick Solberg
- GitHub: [patricksolberg](https://github.com/patricksolberg) 