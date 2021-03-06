package de.Ste3et_C0st.Furniture.Objects.RPG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.EntityEffect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;

import de.Ste3et_C0st.Furniture.Main.main;
import de.Ste3et_C0st.FurnitureLib.Events.FurnitureBreakEvent;
import de.Ste3et_C0st.FurnitureLib.Events.FurnitureClickEvent;
import de.Ste3et_C0st.FurnitureLib.main.Furniture;
import de.Ste3et_C0st.FurnitureLib.main.FurnitureLib;
import de.Ste3et_C0st.FurnitureLib.main.ObjectID;
import de.Ste3et_C0st.FurnitureLib.main.Type.SQLAction;
import de.Ste3et_C0st.FurnitureLib.main.entity.fArmorStand;

public class catapult  extends Furniture implements Listener {
	public catapult(ObjectID id) {
		super(id);
		if(isFinish()){
			Bukkit.getPluginManager().registerEvents(this, main.getInstance());
			return;
		}
		spawn(id.getStartLocation());
	}
	
	HashMap<Entity, Player> fallingSandList = new HashMap<Entity, Player>();
	
	
	@Override
	public void spawn(Location paramLocation) {
		List<fArmorStand> asList = new ArrayList<fArmorStand>();
		double d = .05;
		for(int i =0;i<5;i++){
			Location loc = getRelative(getCenter(), -.5+i*.61, -.26-d).add(0, -1.8, 0);
			fArmorStand stand = spawnArmorStand(loc);
			stand.setHelmet(new ItemStack(Material.LOG));
			stand.setHeadPose(getLutil().degresstoRad(new EulerAngle(90, 0, 0)));
			asList.add(stand);
		}
		
		for(int i =0;i<5;i++){
			Location loc = getRelative(getCenter(), -.5+i*.61, -2+.28+d).add(0, -1.8, 0);
			fArmorStand stand = spawnArmorStand(loc);
			stand.setHelmet(new ItemStack(Material.LOG));
			stand.setHeadPose(getLutil().degresstoRad(new EulerAngle(90, 0, 0)));
			asList.add(stand);
		}
		
		for(int i =0;i<4;i++){
			Location loc = getRelative(getCenter(), .9 , -.26-d).add(0, -.9+i*.43, 0);
			fArmorStand stand = spawnArmorStand(loc);
			stand.setHelmet(new ItemStack(Material.LOG));
			stand.setSmall(true);
			asList.add(stand);
		}
		
		for(int i =0;i<4;i++){
			Location loc = getRelative(getCenter(), .9 , -2+.28+d).add(0, -.9+i*.43, 0);
			fArmorStand stand = spawnArmorStand(loc);
			stand.setHelmet(new ItemStack(Material.LOG));
			stand.setSmall(true);
			asList.add(stand);
		}
		
		Location loc = getRelative(getCenter(), getBlockFace(), .15, -.2).add(0, -1.6, 0);
		fArmorStand stand = spawnArmorStand(loc);
		stand.setItemInMainHand(new ItemStack(Material.STICK));
		stand.setMarker(false);
		stand.setRightArmPose(getLutil().degresstoRad(new EulerAngle(80,0,90)));
		asList.add(stand);
		
		loc = getRelative(getCenter(), getBlockFace(), 2.8-.12, -.2).add(0, -1.6, 0);
		stand = spawnArmorStand(loc);
		stand.setItemInMainHand(new ItemStack(Material.STICK));
		stand.setMarker(false);
		stand.setRightArmPose(getLutil().degresstoRad(new EulerAngle(80,0,90)));
		asList.add(stand);
		
		loc = getRelative(getCenter(), getBlockFace(), 1.5-.12, -.2).add(0, -1.6, 0);
		stand = spawnArmorStand(loc);
		stand.setItemInMainHand(new ItemStack(Material.STICK));
		stand.setMarker(false);
		stand.setRightArmPose(getLutil().degresstoRad(new EulerAngle(80,0,90)));
		asList.add(stand);
		
		loc = getRelative(getCenter(), getBlockFace(), 1.5-.12, -.2).add(0, 0, 0);
		stand = spawnArmorStand(loc);
		stand.setItemInMainHand(new ItemStack(Material.STICK));
		stand.setMarker(false);
		stand.setRightArmPose(getLutil().degresstoRad(new EulerAngle(80,0,90)));
		asList.add(stand);
		
		loc = getRelative(getCenter(), getBlockFace(), 1.5-.3, -1.4).add(0, -1.1, 0);
		loc.setYaw(getYaw()+180);
		stand = spawnArmorStand(loc);
		stand.setItemInMainHand(new ItemStack(Material.STICK));
		stand.setMarker(false);
		stand.setRightArmPose(getLutil().degresstoRad(new EulerAngle(335,0,0)));
		asList.add(stand);
		
		loc = getRelative(getCenter(), getBlockFace(), .4, -1.4).add(0, -.9, 0);
		loc.setYaw(getYaw()+180);
		stand = spawnArmorStand(loc);
		stand.setItemInMainHand(new ItemStack(Material.STICK));
		stand.setRightArmPose(getLutil().degresstoRad(new EulerAngle(335,0,0)));
		stand.setMarker(false);
		asList.add(stand);
		
		loc = getRelative(getCenter(), getBlockFace(), -.8, -1.03).add(0, -1.2, 0);
		loc.setYaw(getYaw());
		stand = spawnArmorStand(loc);
		stand.setHelmet(new ItemStack(Material.STEP));
		stand.setHeadPose(getLutil().degresstoRad(new EulerAngle(15,0,0)));
		asList.add(stand);
		
		for(fArmorStand asp : asList){
			asp.setInvisible(true);
		}
		
		send();
		Bukkit.getPluginManager().registerEvents(this, getPlugin());
	}

	@EventHandler
	public void onFurnitureBreak(FurnitureBreakEvent e) {
		if(getObjID()==null){return;} 
		if(getObjID().getSQLAction().equals(SQLAction.REMOVE)){return;}
		if(e.isCancelled()) return;
		if(e.getID() == null || getObjID() == null) return;
		if(!e.getID().equals(getObjID())) return;
		if(!e.canBuild()){return;}
		e.remove();
		delete();
	}
	
	@EventHandler
	public void onFallingSand(EntityChangeBlockEvent e){
		if(e.getEntity()==null) return;
		if(e.getEntity() instanceof FallingBlock){
			if(fallingSandList.containsKey(e.getEntity())){
				Entity entity = e.getEntity();
				Player p = fallingSandList.get(e.getEntity());
				fallingSandList.remove(e.getEntity());
				Block b = entity.getLocation().getBlock().getRelative(BlockFace.DOWN);
				if(!FurnitureLib.getInstance().getPermManager().canBuild(p, b.getLocation())){
					e.setCancelled(true);
					e.getEntity().remove();
				}
			}
		}
	}
	
	@EventHandler
	public void onPrimedTnt(EntityExplodeEvent e){
		if(e.getEntity()==null) return;
		if(e.getEntity() instanceof TNTPrimed){
			if(fallingSandList.containsKey(e.getEntity())){
				Entity entity = e.getEntity();
				Player p = fallingSandList.get(e.getEntity());
				fallingSandList.remove(e.getEntity());
				Block b = entity.getLocation().getBlock().getRelative(BlockFace.DOWN);
				if(!FurnitureLib.getInstance().getPermManager().canBuild(p, b.getLocation())){
					e.setCancelled(true);
					e.blockList().clear();
					e.getEntity().remove();
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onFurnitureClick(FurnitureClickEvent e) {
		if(getObjID()==null){return;} 
		if(getObjID().getSQLAction().equals(SQLAction.REMOVE)){return;}
		if(e.isCancelled()) return;
		if(!e.getID().equals(getObjID())) return;
		if(!e.canBuild()){return;}
		if(e.getPlayer().getItemInHand()==null){return;}
		if(e.getPlayer().getItemInHand().getType()==null){return;}
		if(!e.getPlayer().getItemInHand().getType().isBlock()){return;}
		Location loc = getRelative(getCenter(), getBlockFace(), -.8, -1.03).add(0, -.2, 0);
		loc.setYaw(getYaw());
		ItemStack stack = e.getPlayer().getItemInHand();
		if(stack.getType().equals(Material.TNT)){
			TNTPrimed tnt = (TNTPrimed) getWorld().spawnEntity(loc, EntityType.PRIMED_TNT);
			Vector v=null;
			switch (getBlockFace()) {
			case NORTH:v= new Vector(0, 0.5, 1.2);break;
			case SOUTH:v= new Vector(0, 0.5, -1.2);break;
			case EAST: v= new Vector(-1.2, 0.5, 0);break;
			case WEST: v= new Vector(1.2, 0.5, 0);break;
			default:break;
			}
			tnt.playEffect(EntityEffect.WITCH_MAGIC);
			tnt.setVelocity(v.multiply(1));
			fallingSandList.put(tnt, e.getPlayer());
		}else{
			FallingBlock block = getWorld().spawnFallingBlock(loc, stack.getType().getId(), (byte) stack.getDurability());
			Vector v=null;
			switch (getBlockFace()) {
			case NORTH:v= new Vector(0, 0.5, 1.2);break;
			case SOUTH:v= new Vector(0, 0.5, -1.2);break;
			case EAST: v= new Vector(-1.2, 0.5, 0);break;
			case WEST: v= new Vector(1.2, 0.5, 0);break;
			default:break;
			}
			block.playEffect(EntityEffect.WITCH_MAGIC);
			block.setDropItem(false);
			block.setVelocity(v.multiply(1));
			fallingSandList.put(block, e.getPlayer());
		}
		
		if(e.getPlayer().getGameMode().equals(GameMode.CREATIVE) && getLib().useGamemode()) return;
		Integer i = e.getPlayer().getInventory().getHeldItemSlot();
		ItemStack is = e.getPlayer().getItemInHand();
		is.setAmount(is.getAmount()-1);
		e.getPlayer().getInventory().setItem(i, is);
		e.getPlayer().updateInventory();
	}
}
